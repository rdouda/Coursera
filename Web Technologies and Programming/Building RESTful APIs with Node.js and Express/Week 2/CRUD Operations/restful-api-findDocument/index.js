const { MongoClient, ServerApiVersion } = require('../restful-api-deleteDocument/node_modules/mongodb/mongodb');

require('../restful-api-deleteDocument/node_modules/dotenv/lib/main').config();

const uri = process.env.MONGODB_URL;

const client = new MongoClient(uri, {
  serverApi: {
    version: ServerApiVersion.v1,
    strict: true,
    deprecationErrors: true,
  }
});

async function run() {
  try {
    await client.connect();

    await client.db("admin").command({ ping: 1 });
    console.log("Pinged your deployment. You successfully connected to MongoDB!");

    const db = client.db();

    const query = { qty: { $gt: 50, $lt: 150 } };
    const options = { projection: { _id: 0, item: 1, qty: 1 } };

    const foundDocuments = await db.collection('inventory').find(query, options);
    const results = await foundDocuments.toArray();
    if (results.length === 0) { // Use estimatedDocumentCount
      console.log("No documents found matching the query.");
    } else {
      console.log("Found documents:");
      results.forEach((doc) => console.log(doc));
    }

  } finally {
    await client.close();
  }
}

run().catch(console.dir);
