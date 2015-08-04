/**
 * This class is the main view for the application. It is specified in app.js as the
 * "autoCreateViewport" property. That setting automatically applies the "viewport"
 * plugin to promote that instance of this class to the body element.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('DataBoard.view.main.Main', {
    extend: 'Ext.container.Container',
    xtype: 'app-main',
    controller: 'main',
    viewModel: {
        type: 'main'
    },
    layout: {
        type: 'border'
    },
    items: [{
        region: 'center',
        xtype: 'gridpanel',
        reference: 'employeeGrid',
        title: 'Employee Data',
        store: 'Employee',
        // requires: [
        //     'Ext.grid.plugin.CellEditing',
        //     'Ext.ux.grid.RowExpander'
        // ],
        tbar: [{
            xtype: 'button',
            text: 'Add Employee',
            handler: 'onAddEmployee'
        }, {
            xtype: 'button',
            text: 'Add Column',
            handler: 'onAddColumn'
        }],
        columns: [{
            text: 'Id',
            dataIndex: 'id'
        }, {
            text: 'Balance',
            dataIndex: 'balance',
        }, {
            text: 'Age',
            dataIndex: 'age'
        }, {
            text: 'EyeColor',
            dataIndex: 'eyeColor'
        }, {
            text: 'Name',
            dataIndex: 'name',
            // editor: {
            //     xtype: 'textfield'
            // }
        }, {
            text: 'Gender',
            dataIndex: 'gender'
        }, {
            text: 'Company',
            dataIndex: 'company'
        }, {
            text: 'E-mail',
            dataIndex: 'email',
            flex: 1
        }, {
            text: 'Phone',
            dataIndex: 'phone',
            flex: 1
        }, {
            xtype: 'actioncolumn',
            width: 30,
            sortable: false,
            menuDisabled: true,
            items: [{
                icon: 'resources/images/icons/delete.gif',
                tooltip: 'Delete Employee',
                handler: 'onRemoveClick'
            }]
        }],
        // selType: 'cellmodel',
        // plugins: [{
        //     ptype: 'cellediting ',
        //     clicksToEdit: 1
        // }],
    }, {
        xtype: 'window',
        reference: 'addemployeeWindow',
        bodyPadding: 15,
        closeAction: 'hide',
        layout: 'fit',
        title: 'Add Employee',
        items: [{
            xtype: 'form',
            defaultType: 'textfield',
            border: false,
            items: [{
                fieldLabel: 'Id',
                name: 'id',
                allowBlank: false
            }, {
                fieldLabel: 'Balance',
                name: 'balance',
                allowBlank: false
            }, {
                fieldLabel: 'Age',
                name: 'age',
                allowBlank: false
            }, {
                fieldLabel: 'EyeColor',
                name: 'eyeColor',
                allowBlank: false
            }, {
                fieldLabel: 'Name',
                name: 'name',
                allowBlank: false
            }, {
                fieldLabel: 'Gender',
                name: 'gender',
                allowBlank: false
            }, {
                fieldLabel: 'Company',
                name: 'company',
                allowBlank: false
            }, {
                fieldLabel: 'Email',
                name: 'email',
                allowBlank: false
            }, {
                fieldLabel: 'Phone',
                name: 'phone',
                allowBlank: false
            }],
            buttons: [{
                text: 'Reset',
                handler: 'onReset'
            }, {
                text: 'Submit',
                formBind: true,
                disabled: true,
                handler: 'onsubmit'
            }]
        }],
    }]
});
