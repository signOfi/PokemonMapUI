import { TimeOfEncounter } from './time-of-encounter.enum';
import { GameVersion } from './game-version.enum'

export interface EncounterDTO {
  id: number;
  pokemonName: string;
  minLevel: number;
  maxLevel: number;
  timeOfEncounter: TimeOfEncounter[];
  encounterRate: number;
  encounterMethod: string;
  versions: GameVersion[];
  subLevel?: string | null;
}

