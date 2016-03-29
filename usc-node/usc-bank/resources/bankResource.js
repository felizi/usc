"use strict";

class BankResource {
    constructor() {
        
    }

    find(req, res, next) {
        var bank = {
            id: req.params.id
        }

        this.bankBusiness = require("../business/bankBusiness");
        this.bankBusiness.find(bank, function callback(err, data) {
            res.writeHead(200, {
                'Content-Type': 'application/json; charset=utf-8'
            });
            res.end(JSON.stringify(data));
            next();
        });
    }

    findAll(req, res, next) {
        this.bankBusiness = require("../business/bankBusiness");
        this.bankBusiness.findAll(function callback(err, data) {
            res.writeHead(200, {
                'Content-Type': 'application/json; charset=utf-8'
            });
            res.end(JSON.stringify(data));
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
            next();
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
            res.end(JSON.stringify(data));
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
        this.bankBusiness.update(bank, function(err, data) {
            res.writeHead(200, {
                'Content-Type': 'application/json; charset=utf-8'
            });
            res.end(JSON.stringify(data));
            next();
        });
    }
}
module.exports = new BankResource();