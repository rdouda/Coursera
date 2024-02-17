// Import necessary modules from the 'mongodb' library
const { MongoClient, ServerApiVersion } = require('mongodb');

// Load environment variables from the .env file
require('dotenv').config();

// Get the MongoDB connection string from the environment variables
const uri = process.env.MONGODB_URL;

// Create a new MongoClient instance with specified server API options
const client = new MongoClient(uri, {
  serverApi: {
    version: ServerApiVersion.v1, // Set the server API version to v1
    strict: true, // Enable strict mode for server API
    deprecationErrors: true, // Log deprecation errors
  }
});

async function run() {
  try {
    await client.connect();

    await client.db("admin").command({ ping: 1 });
    console.log("Pinged your deployment. You successfully connected to MongoDB!");

    // Access the 'inventory' collection in the connected database
    const db = client.db();

    // TODO: Delete operations

  } finally {
    await client.close();
  }
}

run().catch(console.dir);
