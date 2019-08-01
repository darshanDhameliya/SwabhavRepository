const MongoClient = require('mongodb').MongoClient;
const url = "mongodb+srv://Darshan:root@cluster0-tdabg.mongodb.net/test?retryWrites=true&w=majority";
const client = new MongoClient(url, { useNewUrlParser: true });
client.connect((err) => {
    if (err) throw err;
    console.log('connected');

    const collection = client.db("swabhav").collection("contactDetail");

    collection.findOne({}, (err, result) => {
        if (err) throw err;
        console.log(result);
    });
    client.close();
});