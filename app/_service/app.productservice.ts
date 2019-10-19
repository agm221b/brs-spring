import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})

export class ProductService{

    temp:any;

    //Dependency Injection
    constructor(private myhttp:HttpClient){}

    getAllData(){
        return this.myhttp.get('http://localhost:9088/product/getAll');
    }

    addProduct(data:any){
        //For RequestBody
        //return this.myhttp.post('http://localhost:9088/product/add',data);
        
        //For Model Attribute
        let form=new FormData();
        form.append("prodId", data.prodId);
        form.append("prodName", data.prodName);
        form.append("prodCost", data.prodCost);
        return this.myhttp.post('http://localhost:9088/product/add', form);
    }

    deleteProduct(id:number){ 
        return this.myhttp.delete("http://localhost:9088/product/delete?prodId="+id);
    }

    searchProduct(id:number){
        return this.myhttp.get('http://localhost:9088/product/search?prodId='+id);
    }

    updateProduct(data:any){
        return this.myhttp.put('http://localhost:9088/product/update',data);
    }

}