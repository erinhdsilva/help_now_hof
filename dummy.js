const express = require('express')
const axios = require("axios");
const cors = require( "cors");

const app = express();
const port = process.env.PORT || 3000;
const pinataApiKey = "952edca779336903e0b8";
const pinataSecretApiKey = "360f4ef0c61355169235f315bba5a3c00430828022a26f1102453ad624223985";
const reladd = "0x25AAC613049F56779064905749F18A0423447115";
const conadd = "0x6b8bf66290cC88e594FBF8e8cb7E75D5e26F3673";

// Setting path for public directory 
app.use(express.urlencoded({ extended: true }));
app.use(express.json());
app.use(cors())

// Handling request 
app.get("/request-ipfs-data", async (req, res) => {

    const data = JSON.stringify({
        name : "erin"
    });
    // const data = req.body()

    const config = {
        headers: {
            'Content-Type': 'application/json',
            'pinata_api_key': pinataApiKey.toString(),
            'pinata_secret_api_key': pinataSecretApiKey.toString(),
        },
        body: data
    };
    const response = await axios.post('https://api.pinata.cloud/pinning/pinJSONToIPFS',data,{
        headers: {
            'Content-Type': 'application/json',
            'pinata_api_key': pinataApiKey.toString(),
            'pinata_secret_api_key': pinataSecretApiKey.toString(),
        }
    });
    console.log(response.data)

    const Url = "https://ipfs.io/ipfs/" + response.data.IpfsHash;
    console.log("hello")
    // console.log(Url);

    res.json([{
        message: "Successful",
        data: Url,
        error: null,
    }])
})

// Server Setup
app.listen(port, () => {
    console.log(`server is running at ${port}`);
});