export const handleLeetBot=async(request:LeetBotRequest)=>{
    console.log(request)
    try{
        const response=await axios.post("http://localhost:8000/get_leetcode_hint",request);
        console.log(response)
        if(response.data.response){
            return response.data;
        }
        return {"response":response.data};
    }
     catch(error){
        console.error(error)
    }
}