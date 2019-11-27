import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MoviestoreComponent } from './moviestore.component';

describe('MoviestoreComponent', () => {
  let component: MoviestoreComponent;
  let fixture: ComponentFixture<MoviestoreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MoviestoreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MoviestoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
