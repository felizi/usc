"use strict";

class BankBusiness {
    constructor() {

    }

    find(bank, callback) {
        this.session = require("../factory/sessionFactory");
        this.session.connect();

        console.log('Finding Bank: ' + JSON.stringify(bank));

        this.session.connection.query('SELECT * FROM bank WHERE id = ?', bank.id,
            function(err, rows, fields) {
                if (err) throw err;
                console.log('Selected ' + rows.length + ' rows');
                this.end();
                callback(err, rows);
            });
    }

    findAll(callback) {
        this.session = require("../factory/sessionFactory");
        this.session.connect();

        console.log('Finding all Banks');

        this.session.connection.query('SELECT * FROM bank',
            function(err, rows, fields) {
                if (err) throw err;
                console.log('Selected ' + rows.length + ' rows');
                this.end();
                callback(err, rows);
            });
    }

    insert(bank, callback) {
        this.session = require("../factory/sessionFactory");
        this.session.connect();

        console.log('Inserting Bank: ' + JSON.stringify(bank));

        this.session.connection.query('INSERT INTO bank set ? ', bank,
            function(err, result) {
                if (err) throw err;
                console.log('Inserted ' + result.affectedRows + ' rows');
                this.end();
                callback(err, 'Inserted ' + result.affectedRows + ' rows');
            });
    }

    delete(bank, callback) {
        this.session = require("../factory/sessionFactory");
        this.session.connect();

        console.log('Deleting Bank: ' + JSON.stringify(bank));

        this.session.connection.query('DELETE FROM bank WHERE ?', bank,
            function(err, result) {
                if (err) throw err;
                console.log('Deleted ' + result.affectedRows + ' rows');
                this.end();
                callback(err, 'Deleted ' + result.affectedRows + ' rows');
            });
    }

    update(bank, callback) {
        this.session = require("../factory/sessionFactory");
        this.session.connect();
        
        console.log('Updating Bank: ' + JSON.stringify(bank));

        this.session.connection.query('UPDATE bank SET digit = ?, sigla = ?, name = ?, description = ? WHERE id = ?', [bank.digit, bank.sigla, bank.name, bank.description, bank.id],
            function(err, result) {
                if (err) throw err;
                console.log('Updated ' + result.changedRows + ' rows');
                this.end();
                callback(err, 'Updated ' + result.changedRows + ' rows');
            });
    }
}
module.exports = new BankBusiness();