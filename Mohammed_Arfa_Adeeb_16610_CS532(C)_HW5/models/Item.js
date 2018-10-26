function Item(itemName,itemQty){
    this.itemName=itemName;
    this.itemQty=itemQty;
};

Item.prototype.display=function(ItemName,ItemQuantity){
    console.log("ItemName:"+ItemName+" ItemQuantity:"+ItemQuantity);
};

module.exports=Item;




