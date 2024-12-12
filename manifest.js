let extensionWindowId = null; // Global variable to track the extension window ID

chrome.action.onClicked.addListener(() => {
  chrome.windows.getAll({ populate: true }, (windows) => {
    // Check if the extension window is already open
    if (extensionWindowId) {
      chrome.windows.get(extensionWindowId, (existingWindow) => {
        if (chrome.runtime.lastError || !existingWindow) {
          // Window ID is invalid, create a new persistent window
          createPersistentWindow();
        } else {
          // Focus the existing window
          chrome.windows.update(extensionWindowId, { focused: true });
        }
      });
    } else {
      // No extension window is open, create one
      createPersistentWindow();
    }
  });



// Function to create a new persistent window
function createPersistentWindow() {
  chrome.windows.getCurrent({ populate: true }, (currentWindow) => {
    const screenWidth = currentWindow.width || 800;
    const screenHeight = currentWindow.height || 600;
    const leftPosition = (currentWindow.left || 0) + screenWidth - Math.floor(screenWidth / 4);
    const topPosition = currentWindow.top || 0;

    chrome.windows.create({
      url: "popup.html",
      type: "popup",
      width: Math.floor(screenWidth / 4),
      height: screenHeight,
      left: leftPosition,
      top: topPosition,
    }, (newWindow) => {
      if (chrome.runtime.lastError) {
        console.error("Error creating window:", chrome.runtime.lastError.message);
        return;
      }
      extensionWindowId = newWindow.id;
    });
  });
}


// Handle the extension window being closed
chrome.windows.onRemoved.addListener((windowId) => {
  if (windowId === extensionWindowId) {
    extensionWindowId = null; // Reset the ID when the window is closed
  }
});
