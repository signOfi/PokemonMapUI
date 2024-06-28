import { Component, OnInit } from '@angular/core';
import { EncounterDTO } from "../model/encounterDTO";
import { EncounterService } from "/Users/anthonylam/Desktop/Projects/PokemonAPI/Pokemon-Frontend/src/service/encounter.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {  // Ensure it implements OnInit

  encounters: EncounterDTO[] = [];

  constructor(private encounterService: EncounterService) { }

  ngOnInit(): void {
    this.getPokemonEncounters();  // Fetch data on component initialization
  }

  getPokemonEncounters(): void {
    this.encounterService.getEncounters().subscribe((encounters: EncounterDTO[]) => {
      this.encounters = encounters;
      console.log(this.encounters);  // Log the encounters to verify data
    });
  }
}
