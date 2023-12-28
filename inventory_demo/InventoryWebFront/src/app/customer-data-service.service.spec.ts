import { TestBed } from '@angular/core/testing';
import {CustomerDataService} from "./customer-data-service.service";



describe('CustomerDataServiceService', () => {
  let service: CustomerDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomerDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
