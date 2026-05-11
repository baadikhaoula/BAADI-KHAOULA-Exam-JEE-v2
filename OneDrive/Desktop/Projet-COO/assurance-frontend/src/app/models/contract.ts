import { Customer } from './customer';

export interface Contract {
  id?: number;
  type?: string;
  subscriptionDate?: Date;
  status?: string;
  cotisation?: number;
  duration?: number;
  coverageRate?: number;
  customer?: Customer;
  // Auto
  immatriculation?: string;
  brand?: string;
  model?: string;
  // Home
  housingType?: string;
  address?: string;
  area?: number;
  // Health
  coverageLevel?: string;
  nbPersonsCovered?: number;
}
