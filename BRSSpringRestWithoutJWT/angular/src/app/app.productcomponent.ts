import { Component, OnInit,OnChanges,OnDestroy} from '@angular/core'
import { ProductService} from './_service/app.productservice';
import {Product} from './_model/app.product';


@Component({
    selector: 'prod',
    templateUrl: 'app.product.html'
})
export class ProductComponent {
    model:any={};
    loadComponent = false;
    constructor(private service:ProductService){
        console.log("In constructor....");
    }

    // ngOnChanges(){
    //     console.log("NG On Changes.....");
    // }
    
    //  ngOnDestroy(){
    //      console.log("NG On Destroy....");
         
      //}
     addProduct(): any {
         //alert("Hello....")
         console.log(this.model);
         this.service.addData(this.model).subscribe((data)=>console.log(data));

     }

    // updateProduct(index): any {
    //     this.loadComponent=true;
    // }

     deleteProduct(index): any {
         this.service.deleteData(index).subscribe(()=>console.log("Product Deleted"));
     }

     searchProduct(prodId):any{
         let productdetails:Product[]
     }
}