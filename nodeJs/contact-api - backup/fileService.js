let fs = require('fs');
class fileService {
    constructor(fileName) {
        this._fs = require('fs');
        this._fileName = fileName;
    }
    write(data) {
        let jsonData = JSON.stringify(data);
        fs.writeFileSync(this._fileName, jsonData, 'utf8');
    }
    read() {
        let data = fs.readFileSync(this._fileName, 'utf8');

        if (data == [])
            return null;

        let contactData = JSON.parse(data);

        return contactData;
    }
}
module.exports = fileService;