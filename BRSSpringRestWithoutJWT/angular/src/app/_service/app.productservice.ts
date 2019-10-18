import {Injectable} from '@angular/core'
import {HttpClient} from '@angular/common/http'

@Injectable({
    providedIn:'root'
})
export class ProductService{
constructor(private myhttp:HttpClient){}

getAllData(){
    return this.myhttp.get("http://localhost:9088/product/getall")
}

addData(data:any){
    let form=new FormData();
    form.append("prodId",data.prodId);
    form.append("prodName",data.prodName);
    form.append("prodCost",data.prodCost);
    form.append("prodDescription",data.prodDescription);
    return this.myhttp.post("http://localhost:9088/product/add",form);
}
deleteData(prodId){
    return this.myhttp.delete("http://localhost:9088/product/delete?prodId="+prodId);
}
}