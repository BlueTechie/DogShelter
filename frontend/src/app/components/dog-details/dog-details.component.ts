import {Component, OnInit} from '@angular/core';
import {DogDto} from "../../dtos";
import {ActivatedRoute, Router} from "@angular/router";
import {DogService} from "../../services/dog.service";

@Component({
  selector: 'app-dog-details',
  templateUrl: './dog-details.component.html',
  styleUrls: ['./dog-details.component.scss']
})
export class DogDetailsComponent implements OnInit{
  dog: DogDto | null = null;

  constructor(private route:ActivatedRoute, private router:Router, private dogService: DogService) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      const id = params.get('id');
      console.log("Test:",id);
      if(id){
        this.fetchDog(+id);
      }
    });

  }

  goBack(): void {
    this.router.navigate(['/']);
  }

  fetchDog(id: number) {
    this.dogService.getDogById(id).subscribe(
      (data) => {
        this.dog = data;
      }
    );
  }
}
