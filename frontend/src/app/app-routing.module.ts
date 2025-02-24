import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ExamplePageComponent } from './components';

const routes: Routes = [
  { path: '', component: ExamplePageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
