import { Component, OnInit } from '@angular/core';
import { PokemonService } from '../services/pokemon.service';
import { LocationDTO } from '../models/locationDTO';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  locations: LocationDTO[] = [];

  constructor(private pokemonService: PokemonService) {}

  ngOnInit(): void {
    this.getEncounters(14, 'WALKING', ['DAY', 'NIGHT', 'MORNING']);  // Example call
  }

  getEncounters(locationId: number, method: string, times: string[]): void {
    this.pokemonService.getEncountersByMethodAndTime(locationId, method, times).subscribe({
      next: (data: LocationDTO[]) => this.locations = data,
      error: (error: any) => console.error('Failed to fetch data:', error)
    });
  }
}
