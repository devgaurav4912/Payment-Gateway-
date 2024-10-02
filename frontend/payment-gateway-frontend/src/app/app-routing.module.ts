import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PaymentFormComponent } from './payment-form/payment-form.component';

const routes: Routes = [
{
  component :PaymentFormComponent,
  path : ""
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
