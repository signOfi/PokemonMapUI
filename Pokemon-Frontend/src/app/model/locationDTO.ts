import {EncounterDTO} from "./encounterDTO";

export interface LocationDTO {
  id: number;
  name: string;
  encounter: EncounterDTO[]
}
