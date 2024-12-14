import React, { useEffect, useState } from 'react';
import { useChatStore, useUserStore } from '../store/useStore';
import { MessageSquare } from 'lucide-react';

const ThreadSelector: React.FC = () => {
  const { threads, activeThreadId, switchThread, toggleSidebar } = useChatStore();
  const { loadUserInfoFromStorage } = useUserStore();
  const [localGithubUsername, setLocalGithubUsername] = useState('');
  const [accessToken, setAccessToken] = useState('');

  useEffect(() => {
    const loadUserInfo = async () => {
      const userInfo = await loadUserInfoFromStorage();  // Correct way to call the function
      if (userInfo) {
        setLocalGithubUsername(userInfo.github_username);
        setAccessToken(userInfo.access_token);
      } else {
        // Handle user not found in storage (could redirect to login, for example)
        console.log("User info not found in storage.");
      }
    };

    loadUserInfo();
  }, [loadUserInfoFromStorage]); // Load user info once when the component is mounted

  useEffect(() => {
    // Only switch thread if we have both github username and access token
    if (localGithubUsername.trim() !== '' && accessToken.trim() !== '') {
      handleSwitchThread(localGithubUsername, accessToken); 
    }
  }, [localGithubUsername, accessToken]); // Dependency on both Github username and access token

  const handleSwitchThread = async (thread_id: string) => {
    toggleSidebar();
    await switchThread(thread_id, localGithubUsername, accessToken); // Ensure these values are passed correctly
  };

  return (
    <div className="flex flex-col text-gray-300 w-64 p-2 overflow-y-scroll h-[85%] ">
      <div className="flex-grow overflow-y-auto">
        {threads.map((thread) => (
          <button
            key={thread.thread_id}
            onClick={() => handleSwitchThread(thread.thread_id)}
            className={`flex items-center w-full px-3 py-3 mb-1 text-sm rounded-md transition-colors duration-200 $
              {activeThreadId === thread.thread_id ? 'bg-[#3C3B3B] text-white' : 'hover:bg-[#494747] hover:text-white'
            }`}
          >
            <MessageSquare className="w-4 h-4 mr-2 flex-shrink-0" />
            <span className="truncate">
              {thread?.title || `Thread ${thread.thread_id}`}
            </span>
          </button>
        ))}
      </div>
    </div>
  );
};

export default ThreadSelector;