import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-spinner-component',
  templateUrl: './spinner-component.component.html',
  styleUrl: './spinner-component.component.css'
})
export class SpinnerComponentComponent {
  @Input() size = 50;
  @Input() show: boolean;
}
