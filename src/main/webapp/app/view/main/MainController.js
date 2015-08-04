/**
 * This class is the main view for the application. It is specified in app.js as the
 * "autoCreateViewport" property. That setting automatically applies the "viewport"
 * plugin to promote that instance of this class to the body element.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */

Ext.override(Ext.grid.GridPanel, {
    addColumn: function(field, column, colIndex) {
        if (!column) {
            if (field.dataIndex) {
                column = field;
                field = field.dataIndex;
            } else {
                column = field.name || field;
            }
        }
        this.store.addField(field);
        return this.colModel.addColumn(column, colIndex);
    },
    removeColumn: function(name, colIndex) {
        this.store.removeField(name);
        if (typeof colIndex != 'number') {
            colIndex = this.colModel.findColumnIndex(name);
        }
        if (colIndex >= 0) {
            this.colModel.removeColumn(colIndex);
        }
    }
});
Ext.define('DataBoard.view.main.MainController', {
    extend: 'Ext.app.ViewController',

    requires: [
        'Ext.MessageBox',
        'Ext.tree.View'
    ],

    alias: 'controller.main',

    onClickButton: function() {
        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
    },

    onConfirm: function(choice) {
        if (choice === 'yes') {
            //
        }
    },
    onRemoveClick: function(grid, rowIndex) {
        console.log(this);
        grid.getStore().removeAt(rowIndex);
    },
    onAddEmployee: function() {
        console.log(this);
        this.lookupReference("addemployeeWindow").show();
        // addemployeeWindow.show();
    },
    onReset: function(btn) {
        btn.up('form').getForm().reset();
    },
    onsubmit: function(btn) {
        var form = btn.up('form').getForm();
        if (form.isValid()) {
            Ext.getStore('Employee').add(form.getValues());
            this.lookupReference("addemployeeWindow").hide();
        }
    },
    onAddColumn: function() {
        alert("Hi");
        var gridView = Ext.ComponentQuery.query("gridpanel")[0];
        var column = Ext.create('Ext.grid.column.Column', {
            text: 'New Column',
            sortable: true,
            defaultValue: "Beena"
        });
        gridView.headerCt.insert(gridView.columns.length, column);
        gridView.getView().refresh();
        // grid.addColumn({
        //     name: 'D',
        //     defaultValue: 'D'
        // }, {
        //     header: 'D',
        //     dataIndex: 'D'
        // });
    }
});
