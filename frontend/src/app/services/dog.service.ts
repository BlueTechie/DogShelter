import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';
import {DogDto, LightDogDto} from "../dtos";


@Injectable({
  providedIn: 'root'
})
export class DogService {

  private apiUrl = 'http://localhost:8080/dogs';

  constructor(private http: HttpClient) { }

  getAllDogs(): Observable<LightDogDto[]>{
    return this.http.get<LightDogDto[]>(this.apiUrl);
  }

  getDogById(id: number): Observable<DogDto>{
    return this.http.get<DogDto>(`${this.apiUrl}/${id}`);
  }

  createDog(dog: DogDto): Observable<DogDto>{
    return this.http.post<DogDto>(this.apiUrl, dog)
  }

  updateDog(id: number, dog: DogDto): Observable<DogDto>{
    return this.http.put<DogDto>(`${this.apiUrl}/${id}`, dog).pipe(
      catchError(err => {
        if (err.status === 404) {
          return throwError('Dog not found! The ID you provided does not exist.');
        }
        return throwError('An error occurred while updating the dog details.');
      })
    );
  }

  deleteDog(id: number): Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

}
