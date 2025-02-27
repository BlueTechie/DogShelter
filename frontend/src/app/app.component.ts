import {Component, OnInit} from '@angular/core';
import {LightDogDto} from "./dtos";
import {DogService} from "./services/dog.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  dogs: LightDogDto[] = [];

  constructor(private dogService: DogService, private router: Router) {}

  ngOnInit() {
    this.router.events.subscribe(() => {
      this.fetchDogs();  // Always refresh list on navigation
    });
  }

  fetchDogs() {
    this.dogService.getAllDogs().subscribe(
      (data) => this.dogs = data,
      (error) => console.error("Error fetching dogs:", error)
    );
  }

  onDogUpdated() {
    this.fetchDogs()
  }

  onDogAdded() {
    this.fetchDogs();
  }



}
