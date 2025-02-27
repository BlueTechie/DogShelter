export interface DogDto {
  id?: number;  // Optional for creation
  name: string;
  age: number;
  sex: 'MALE' | 'FEMALE';
  vaccinated: boolean;
  color: 'BROWN' | 'WHITE' | 'BLACK' | 'GRAY' | 'GOLDEN' | 'MIXED';
}
