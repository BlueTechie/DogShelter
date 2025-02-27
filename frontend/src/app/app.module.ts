import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ExamplePageComponent } from './components/pages/example-page/example-page.component';
import { ExampleSharedComponent } from './components/shared/example-shared/example-shared.component';
import { RouterModule } from '@angular/router';
import { DogListComponent } from './components/dog-list/dog-list.component';
import { DogDetailsComponent } from './components/dog-details/dog-details.component';
import { DogFormComponent } from './components/dog-form/dog-form.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    ExamplePageComponent,
    ExampleSharedComponent,
    DogListComponent,
    DogDetailsComponent,
    DogFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
