import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DogListComponent, DogDetailsComponent, DogFormComponent } from './components';

const routes: Routes = [
  { path: 'edit/:id', component: DogFormComponent },
  { path: 'dogs/:id', component: DogDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
