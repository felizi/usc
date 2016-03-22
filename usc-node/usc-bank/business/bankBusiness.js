"use strict";

class BankBusiness {
  findAll(callback) {
    this.session = require("../factory/sessionFactory");
    this.session.connect();
    this.session.connection.query('SELECT * FROM bank',
      function(err, rows, fields) {
        if (err) throw err;
        console.log('Selected ' + rows.length + ' rows');
        callback(rows);
        this.session.end();
      });
  }

  insert(bank, callback) {
    this.session = require("../factory/sessionFactory");
    this.session.connect();
    this.session.connection.query('INSERT INTO bank set ? ', bank,
      function(err, result) {
        if (err) throw err;
        console.log('Inserted ' + result.affectedRows + ' rows');
      });
  }

  delete(bank, callback) {
    this.session = require("../factory/sessionFactory");
    this.session.connect();
    this.session.connection.query('DELETE FROM bank WHERE ?', bank,
      function(err, result) {
        if (err) throw err;
        console.log('Deleted ' + result.affectedRows + ' rows');
      });
  }

  update(bank, callback) {
    this.session = require("../factory/sessionFactory");
    this.session.connect();
    this.session.connection.query('UPDATE bank SET digit = ? AND sigla = ? AND name = ? AND description = ? WHERE id = ?', [bank.digit, bank.sigla, bank.name, bank.description, bank.id],
      function(err, result) {
        if (err) throw err;
        console.log('Updated ' + result.affectedRows + ' rows');
      });
  }
}
module.exports = new BankBusiness();
