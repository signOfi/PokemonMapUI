import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-pokemon-image',
  templateUrl: './pokemon-image.component.html',
  styleUrl: './pokemon-image.component.css'
})
export class PokemonImageComponent implements OnInit{

  @Input() pokemonName!: string;
  imagePath!: string;

  ngOnInit(): void {
    this.imagePath = this.getImagePath(this.pokemonName);
  }

  private getImagePath(name: string): string {
    const formatted = name.charAt(0).toUpperCase() + name.slice(1);
    return "assets/pokemonSprites/" + formatted + ".png";
  }

}
