import { Component,OnInit} from '@angular/core';
import { ProductService} from './_service/app.productservice';
import {Product} from './_model/app.product';
import { ActivatedRoute } from '@angular/router'

@Component({
    selector:'show',
    templateUrl:'app.showproduct.html'
})
export class ShowComponent implements OnInit{
    product:Product;
   id;
    products: Product[] = [];
    constructor(private service:ProductService){
        console.log("In constructor....");
    }
    sub;
    ngOnInit(): void {
        console.log("NG On Init....");
        this.service.getAllData().subscribe((data:Product[]) =>this.products=data);
        //this.sub=this._Activatedroute.paramMap.subscribe(params => { 
            //console.log(params);
             //this.id = params.get('id'); 
             //this.service.getAllData().subscribe((data:Product[]) =>this.products=data);
             //this.product=this.products.find(p => p.prodId==this.id)
              
         //});
     }

}