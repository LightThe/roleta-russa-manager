import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MotivoCreateComponent } from './motivo-create.component';

describe('MotivoCreateComponent', () => {
  let component: MotivoCreateComponent;
  let fixture: ComponentFixture<MotivoCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MotivoCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MotivoCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
