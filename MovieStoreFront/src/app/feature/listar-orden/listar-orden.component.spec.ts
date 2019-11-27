import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarOrdenComponent } from './listar-orden.component';

describe('ListarOrdenComponent', () => {
  let component: ListarOrdenComponent;
  let fixture: ComponentFixture<ListarOrdenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarOrdenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarOrdenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
