databaseChangeLog {
  changeSet(id: '1438638041571-1', author: 'makingdevs (generated)') {
    createTable(tableName: 'user') {
      column(name: 'id', type: 'BIGINT', autoIncrement: true) {
        constraints(primaryKey: true)
      }
      column(name: 'first_name', type: 'VARCHAR(255)') {
        constraints(nullable: false)
      }
      column(name: 'last_name', type: 'VARCHAR(255)') {
        constraints(nullable: false)
      }
      column(name: 'password', type: 'VARCHAR(255)') {
        constraints(nullable: false)
      }
      column(name: 'role', type: 'VARCHAR(255)') {
        constraints(nullable: false)
      }
      column(name: 'username', type: 'VARCHAR(255)') {
        constraints(nullable: false)
      }
    }
  }

  changeSet(id: '1438638041571-2', author: 'makingdevs (generated)') {
    addUniqueConstraint(columnNames: 'username', constraintName: 'UK_sb8bbouer5wak8vyiiy4pf2bx', deferrable: false, disabled: false, initiallyDeferred: false, tableName: 'user')
  }

  changeSet(id: '1438638041571-3', author: 'josdem') {
    createTable(tableName: 'source') {
      column(name: 'id', type: 'BIGINT', autoIncrement: true) {
        constraints(primaryKey: true)
      }
      column(name: 'name', type: 'VARCHAR(255)') {
        constraints(nullable: false)
      }
    }
  }

  changeSet(id: '1438638041571-4', author: 'josdem') {
    sql("INSERT INTO source VALUES (1,'Canal 1'), (2, 'Canal 2'), (3, 'Canal 3')")
  }

}
