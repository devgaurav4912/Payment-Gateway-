import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiService } from '../api.service';
// import Razorpay from 'razorpay';
declare var Razorpay: any;

@Component({
  selector: 'app-payment-form',
  templateUrl: './payment-form.component.html',
  styleUrls: ['./payment-form.component.css']
})
export class PaymentFormComponent implements OnInit {

  paymentForm!: FormGroup;

  paymentId! :any 

  constructor(private fb: FormBuilder ,
              private apiService : ApiService
  ) {}

  ngOnInit(): void {
    this.paymentForm = this.fb.group({
      name: ['', Validators.required],
      address: ['', Validators.required],
      contactNumber: ['', [Validators.required, Validators.pattern('^\\d{10}$')]], // Validates 10-digit contact number
      totalAmount: ['', [Validators.required, Validators.min(0)]],
      transactionId : this.paymentId
    });
  }

  saveOrderDetails(){

    this.apiService.saveOrderDetails(this.paymentForm.value,)
    .subscribe((res:any)=>{
      console.log("ORDER-DETAILS -->"+res);
    })

   // this.createTransaction();
  }

  createTransaction(): void {
    if (this.paymentForm.valid) {
      console.log('Payment Form Data:', this.paymentForm.value);
      console.log("AMOUNT --> "+this.paymentForm.value.totalAmount);
      this.apiService.crateTrancsaction(this.paymentForm.value.totalAmount)
      .subscribe((res:any)=>{
        console.log("TRANSACTION RES --> "+res);
       this.openTransactionModal(res);
      },(error : any)=>{
        console.log("TRANSACTION-ERROR -->"+error)
      })
    }

    this.saveOrderDetails();
  }

  openTransactionModal(response:any){
    var options = {
      orderId : response.orderId,
      key : response.key,
      amount : response.amount,
      currency : response.currency,
      name : response.name,
      description : response.description,
      image : 'https://cdn.pixabay.com/photo/2023/12/03/10/11/woman-8427201_640.png',
      handler : (res:any)=>{
        console.log("TRANSACTION ID --> "+res.razorpay_payment_id);
        this.paymentId = res.razorpay_payment_id;
        if(res!=null && res.razorpay_payment_id !=null){
          this.processResponse(res)
        }else{
          alert("Payment failed..");
        }
      },
      prefill :{
        name : "tronsoftech",
        email : "tron@gmail.com",
        contact : "9999999999"
      },
      notes : {
        address : "online shoping"
      },
      theme :{
        color : "#F37354"
      }
    };

    var razorPayObject = new Razorpay(options);
    razorPayObject.open();
  }

  processResponse(resp:any){
    console.log(resp)
  }
}
