"use strict";

class EnigmaResource {
  encrypt(req, res, next) {
    this.enigmaBusiness = require("../business/enigmaBusiness");

    var encrypt = {
      text: req.params.encrypt.text,
      password: req.params.encrypt.password
    }

    this.enigmaBusiness.encrypt(encrypt, function callback(crypted) {
      res.writeHead(200, {
        'Content-Type': 'application/json; charset=utf-8'
      });
      res.end(JSON.stringify(crypted));

      next();
    });
  }

  decrypt(req, res, next) {
    this.enigmaBusiness = require("../business/enigmaBusiness");

    var decrypt = {
      text: req.params.decrypt.text,
      password: req.params.decrypt.password
    }

    this.enigmaBusiness.decrypt(decrypt, function callback(decrypted) {
      res.writeHead(200, {
        'Content-Type': 'application/json; charset=utf-8'
      });
      res.end(JSON.stringify(decrypted));

      next();
    });
  }
}
module.exports = new EnigmaResource();