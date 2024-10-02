import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http : HttpClient) { }

  crateTrancsaction(amount : any){
   return this.http.get(`http://localhost:8080/api/payment/createTransaction/${amount}`)
  }
}
