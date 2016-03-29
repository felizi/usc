"use strict";

class SessionFactory {
  
    constructor() {
        var mysql = require('mysql');
        this.connection = mysql.createConnection({
            host: '127.0.0.1',
            user: 'root',
            password: 'root',
            database: 'node_bank'
        });
    }

    connect() {
        console.log(':: Connect ::');
        this.connection.connect();
    }

    end() {
        console.log(':: End ::');
        this.connection.end();
    }
}

module.exports = new SessionFactory();