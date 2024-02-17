// Import necessary modules from the 'mongodb' library
const { MongoClient, ServerApiVersion } = require('mongodb');

// Load environment variables from the .env file
require('dotenv').config();

// Get the MongoDB connection string from the environment variables
const uri = process.env.MONGODB_URL;

// Log the MongoDB connection string to the console
console.log(uri);

// Create a new MongoClient instance with specified server API options
const client = new MongoClient(uri, {
  serverApi: {
    version: ServerApiVersion.v1, // Set the server API version to v1
    strict: true, // Enable strict mode for server API
    deprecationErrors: true, // Log deprecation errors
  }
});

// Define an asynchronous function 'run' to connect to MongoDB and ping the deployment
async function run() {
  try {
    // Connect to the MongoDB deployment using the MongoClient instance
    await client.connect();

    // Send a ping command to the 'admin' database to check the connection
    await client.db("admin").command({ ping: 1 });

    // Log a success message if the connection and ping are successful
    console.log("Pinged your deployment. You successfully connected to MongoDB!");
  } finally {
    // Close the MongoClient connection in the 'finally' block to ensure proper cleanup
    await client.close();
  }
}

// Execute the 'run' function and handle any errors by logging them to the console
run().catch(console.dir);
