export interface EncounterDTO {
  id: number;
  pokemonName: string;
  minLevel: number;
  maxLevel: number;
  timeOfEncounter: string[];
  encounterRate: number;
  encounterMethod: string;
  versions: string[];
  locationName: string;
}

