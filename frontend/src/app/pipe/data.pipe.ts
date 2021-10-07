import { Pipe,PipeTransform } from "@angular/core";

@Pipe({
  name: 'dataPipe'
})
export class DataPipe implements PipeTransform{

  transform(data: string): Date {
    let dataSplit: string[] = data.split('/');
    return new Date(`${dataSplit[2]}-${dataSplit[1]}-${dataSplit[0]}T00:00:00`);
  }

}