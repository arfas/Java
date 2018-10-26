var express=require('express');
var router=express.Router();
var Item=require('../models/Item');

router.post('/addtocart',function(req,res,next){
    req.session.cart.push(new Item(req.body.itemName,req.body.itemQty));
    console.log(req.session.cart);
    res.send({success:true});
    
})
module.exports=router;