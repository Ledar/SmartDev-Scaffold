// SPDX-License-Identifier: Apache-2.0
pragma solidity >=0.6.10 <0.8.20;

import "./Table.sol";

contract Order {

    event CreateResult(int256 count);
    event InsertResult(int256 count);
    event UpdateResult(int256 count);
    event RemoveResult(int256 count);

    TableManager constant tm = TableManager(address(0x1002));
    Table table;
    string constant TABLE_NAME = "order";

    constructor() {
        // create table
        string[] memory columnNames = new string[](1);
        columnNames[0] = "orderInfo";
        TableInfo memory tf = TableInfo("orderNumber", columnNames);

        tm.createTable(TABLE_NAME, tf);
        address t_address = tm.openTable(TABLE_NAME);
        require(t_address != address(0x0), "create table failed");
        table = Table(t_address);
    }

    //select records
    function select(string memory orderNumber)
    public
    view
    returns (string memory, string memory)
    {
        Entry memory entry = table.select(orderNumber);

        string memory orderInfo;
        if (entry.fields.length == 1) {
            orderInfo = entry.fields[0];
        }
        return (orderNumber, orderInfo);
    }

    //insert records
    function insert(string memory orderNumber, string memory orderInfo)
    public
    returns (int256)
    {
        string[] memory columns = new string[](1);
        columns[0] = orderInfo;
        Entry memory entry = Entry(orderNumber, columns);

        int256 count = table.insert(entry);
        emit InsertResult(count);
        return count;
    }

    //update records
    function update(string memory orderNumber, string memory orderInfo)
    public
    returns (int256)
    {
        UpdateField[] memory updateFields = new UpdateField[](1);
        updateFields[0] = UpdateField("orderInfo", orderInfo);

        int256 result = table.update(orderNumber, updateFields);
        emit UpdateResult(result);
        return result;
    }

    //remove records
    function remove(string memory orderNumber) public returns (int256) {
        int256 result = table.remove(orderNumber);
        emit RemoveResult(result);
        return result;
    }
}
