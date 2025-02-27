import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DogService } from '../../services/dog.service';
import { DogDto, LightDogDto } from '../../dtos';
import {DogListComponent} from "../dog-list/dog-list.component";

const noDog : DogDto =  {name: '', age: 0, sex: 'MALE', vaccinated: false, color: 'MIXED' };

@Component({
  selector: 'app-dog-form',
  templateUrl: './dog-form.component.html',
  styleUrls: ['./dog-form.component.scss']
})
export class DogFormComponent implements OnInit{

  dogForm!:FormGroup;
  inEditMode = false;
  errorMessage = '';
  submitted = false;

  constructor(private dogService: DogService,
              private route: ActivatedRoute,
              private router: Router,
              private formBuilder: FormBuilder) {}

  ngOnInit():void {
    const id = this.route.snapshot.paramMap.get('id');
    this.inEditMode = Boolean(id)

    this.dogForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.pattern('^[A-Za-z ]+$')]],
      age: [0, [Validators.required, Validators.min(0), Validators.max(30)]],
      sex: ['MALE', Validators.required],
      vaccinated: [false, Validators.required],
      color: ['MIXED', Validators.required]
    });

    if (this.inEditMode) {
      this.dogService.getDogById(+id!).subscribe((dog: DogDto) => {
        this.dogForm.patchValue(dog);
      });
    }
  }

  saveDog() {
    this.submitted = true;
    if(this.dogForm.invalid) return;

    const dog: DogDto = this.dogForm.value;

    if (this.inEditMode) {
      const id = this.route.snapshot.paramMap.get('id');
      if (!id) {
        console.error('Dog id is missing!');
        return;
      }
      dog.id = +id;
      console.log('Dog to update:', dog);
      console.log("ID: ", dog.id)
      this.dogService.updateDog(dog.id!, dog).subscribe({
        next: () => this.router.navigate(['/']),
        error: (err) => this.handleError(err)
      });
    } else {

      this.dogService.createDog(dog).subscribe({
        next: () => this.router.navigate(['/']),
        error: (err) => this.handleError(err)
      });
    }
  }

  handleError(error: any) {
    this.errorMessage = error;
    console.error(error);
  }

  get f() {
    return this.dogForm.controls as { [key: string]: any };
  }

  goBack(): void {
    this.router.navigate(['/']);
  }

}
