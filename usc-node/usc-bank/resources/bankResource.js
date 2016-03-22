"use strict";

class BankResource {
  findAll(req, res, next) {
    this.bankBusiness = require("../business/bankBusiness");
    this.bankBusiness.findAll(function callback(rows) {
      res.writeHead(200, {
        'Content-Type': 'application/json; charset=utf-8'
      });
      res.end(JSON.stringify(rows));
      // res.json(rows);
      next();
    });
  }

  insert(req, res, next) {
    var bank = {
      digit: req.params.bank.digit,
      sigla: req.params.bank.sigla,
      name: req.params.bank.name,
      description: req.params.bank.description
    }

    this.bankBusiness = require("../business/bankBusiness");
    this.bankBusiness.insert(bank, function(err, data) {
      res.writeHead(200, {
        'Content-Type': 'application/json; charset=utf-8'
      });
      res.end(JSON.stringify(data));
    });
  }

  delete(req, res, next) {
    var bank = {
      id: req.params.bank.id
    }

    this.bankBusiness = require("../business/bankBusiness");
    this.bankBusiness.delete(bank, function(err, data) {
      res.writeHead(200, {
        'Content-Type': 'application/json; charset=utf-8'
      });
      res.end(JSON.stringify(rows));
      // res.json(rows);
      next();
    });
  }

  update(req, res, next) {
    var bank = {
      id: req.params.bank.id,
      digit: req.params.bank.digit,
      sigla: req.params.bank.sigla,
      name: req.params.bank.name,
      description: req.params.bank.description
    }

    this.bankBusiness = require("../business/bankBusiness");
    this.bankBusiness.insert(bank, function(err, data) {
      res.writeHead(200, {
        'Content-Type': 'application/json; charset=utf-8'
      });
      res.end(JSON.stringify(data));
    });
  }
}
module.exports = new BankResource();
