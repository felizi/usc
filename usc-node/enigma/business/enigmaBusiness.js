"use strict";

class EnigmaBusiness {
  encrypt(encrypt, callback) {
    var crypto = require('crypto');
    var algorithm = 'aes-256-ctr';

    var cipher = crypto.createCipher(algorithm, encrypt.password);
    var crypted = cipher.update(encrypt.text, 'utf8', 'hex');
    crypted += cipher.final('hex');

    callback(crypted);
  }

  decrypt(decrypt, callback) {
    var crypto = require('crypto');
    var algorithm = 'aes-256-ctr';

    var decipher = crypto.createDecipher(algorithm, decrypt.password);
    var dec = decipher.update(decrypt.text, 'hex', 'utf8')
    dec += decipher.final('utf8');

    callback(dec);
  }
}
module.exports = new EnigmaBusiness();