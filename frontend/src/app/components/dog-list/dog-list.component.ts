import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import { DogService } from '../../services/dog.service';
import { LightDogDto } from '../../dtos';
import {Router} from "@angular/router";

@Component({
  selector: 'app-dog-list',
  templateUrl: './dog-list.component.html',
  styleUrls: ['./dog-list.component.scss']
})
export class DogListComponent{
  @Input() dogs: LightDogDto[] = [];

  constructor(private dogService: DogService, private router: Router) {};


  deleteDog(id: number){
    if(confirm(`Are you sure you want to delete the dog with id ${id}?`)){
      this.dogService.deleteDog(id).subscribe(() => {
        this.dogs = this.dogs.filter(d => d.id != id)
      });
      this.router.navigate(['/']);
    }
  }

}
