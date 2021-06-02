<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class MapSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('maps')->insert([
            'id' => 1,
            'status' => 'after',
            'area' => 'Desa Loli Pesua Kab Donggala',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Desa%20Loli%20Pesua%20Kab%20Donggala%20After.jpg'
        ]);
        
        DB::table('maps')->insert([
            'id' => 2,
            'status' => 'before',
            'area' => 'Desa Loli Pesua Kab Donggala',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Desa%20Loli%20Pesua%20Kab%20Donggala%20Before.jpg'
        ]);
        
        DB::table('maps')->insert([
            'id' => 3,
            'status' => 'after',
            'area' => 'Kelurahan Layana Indah Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Layana%20Indah%20Kota%20Palu%20After.jpg'
        ]);
        
        DB::table('maps')->insert([
            'id' => 4,
            'status' => 'before',
            'area' => 'Kelurahan Layana Indah Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Layana%20Indah%20Kota%20Palu%20Before.jpg'
        ]);

        DB::table('maps')->insert([
            'id' => 5,
            'status' => 'after',
            'area' => 'Kelurahan Lere Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Lere%20Kota%20Palu%20After.jpg'
        ]);

        DB::table('maps')->insert([
            'id' => 6,
            'status' => 'before',
            'area' => 'Kelurahan Lere Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Lere%20Kota%20Palu%20Before.jpg'
        ]);

        DB::table('maps')->insert([
            'id' => 7,
            'status' => 'after',
            'area' => 'Kelurahan Mamboro Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Mamboro%20Kota%20Palu%20After.jpg'
        ]);

        DB::table('maps')->insert([
            'id' => 8,
            'status' => 'before',
            'area' => 'Kelurahan Mamboro Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Mamboro%20Kota%20Palu%20Before.jpg'
        ]);

        DB::table('maps')->insert([
            'id' => 9,
            'status' => 'after',
            'area' => 'Kelurahan Silae Selatan Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Silae%20Selatan%20Kota%20Palu%20After.jpg'
        ]);

        DB::table('maps')->insert([
            'id' => 10,
            'status' => 'before',
            'area' => 'Kelurahan Silae Selatan Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Silae%20Selatan%20Kota%20Palu%20Before.jpg'
        ]);

        DB::table('maps')->insert([
            'id' => 11,
            'status' => 'after',
            'area' => 'Kelurahan Silae Utara Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Silae%20Utara%20Kota%20Palu%20After.jpg'
        ]);

        DB::table('maps')->insert([
            'id' => 12,
            'status' => 'before',
            'area' => 'Kelurahan Silae Utara Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Silae%20Utara%20Kota%20Palu%20After.jpg'
        ]);

        DB::table('maps')->insert([
            'id' => 13,
            'status' => 'after',
            'area' => 'Kelurahan Tondo Selatan Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Tondo%20Selatan%20Kota%20Palu%20After.jpg'
        ]);

        DB::table('maps')->insert([
            'id' => 14,
            'status' => 'before',
            'area' => 'Kelurahan Tondo Selatan Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Tondo%20Selatan%20Kota%20Palu%20Before.jpg'
        ]);

        DB::table('maps')->insert([
            'id' => 15,
            'status' => 'after',
            'area' => 'Kelurahan Tondo Utara Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Tondo%20Utara%20Kota%20Palu%20After.jpg'
        ]);

        DB::table('maps')->insert([
            'id' => 16,
            'status' => 'before',
            'area' => 'Kelurahan Tondo Utara Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Tondo%20Utara%20Kota%20Palu%20Before.jpg'
        ]);
    }
}
