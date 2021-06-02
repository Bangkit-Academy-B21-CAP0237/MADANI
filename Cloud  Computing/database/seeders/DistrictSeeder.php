<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class DistrictSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('districts')->insert([
            'map_id' => 1,
            'name' => 'Desa Loli Pesua Kab Donggala',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Desa%20Loli%20Pesua%20Kab%20Donggala%20After.jpg'
        ]);

        DB::table('districts')->insert([
            'map_id' => 1,
            'name' => 'Desa Loli Pesua Kab Donggala',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Desa%20Loli%20Pesua%20Kab%20Donggala%20Before.jpg'
        ]);

        DB::table('districts')->insert([
            'map_id' => 2,
            'name' => 'Kelurahan Layana Indah Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Layana%20Indah%20Kota%20Palu%20After.jpg'
        ]);

        DB::table('districts')->insert([
            'map_id' => 2,
            'name' => 'Kelurahan Layana Indah Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Layana%20Indah%20Kota%20Palu%20Before.jpg'
        ]);

        DB::table('districts')->insert([
            'map_id' => 3,
            'name' => 'Kelurahan Lere Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Lere%20Kota%20Palu%20After.jpg'
        ]);

        DB::table('districts')->insert([
            'map_id' => 3,
            'name' => 'Kelurahan Lere Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Lere%20Kota%20Palu%20Before.jpg'
        ]);

        DB::table('districts')->insert([
            'map_id' => 4,
            'name' => 'Kelurahan Mamboro Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Mamboro%20Kota%20Palu%20After.jpg'
        ]);

        DB::table('districts')->insert([
            'map_id' => 4,
            'name' => 'Kelurahan Mamboro Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Mamboro%20Kota%20Palu%20Before.jpg'
        ]);

        DB::table('districts')->insert([
            'map_id' => 5,
            'name' => 'Kelurahan Silae Selatan Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Silae%20Selatan%20Kota%20Palu%20After.jpg'
        ]);

        DB::table('districts')->insert([
            'map_id' => 5,
            'name' => 'Kelurahan Silae Selatan Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Silae%20Selatan%20Kota%20Palu%20Before.jpg'
        ]);

        DB::table('districts')->insert([
            'map_id' => 6,
            'name' => 'Kelurahan Silae Utara Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Silae%20Utara%20Kota%20Palu%20After.jpg'
        ]);

        DB::table('districts')->insert([
            'map_id' => 6,
            'name' => 'Kelurahan Silae Utara Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Silae%20Utara%20Kota%20Palu%20Before.jpg'
        ]);

        DB::table('districts')->insert([
            'map_id' => 7,
            'name' => 'Kelurahan Tondo Selatan Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Tondo%20Selatan%20Kota%20Palu%20After.jpg'
        ]);

        DB::table('districts')->insert([
            'map_id' => 7,
            'name' => 'Kelurahan Tondo Selatan Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Tondo%20Selatan%20Kota%20Palu%20Before.jpg'
        ]);

        DB::table('districts')->insert([
            'map_id' => 8,
            'name' => 'Kelurahan Tondo Utara Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Tondo%20Utara%20Kota%20Palu%20After.jpg'
        ]);

        DB::table('districts')->insert([
            'map_id' => 8,
            'name' => 'Kelurahan Tondo Utara Kota Palu',
            'photo' => 'https://storage.googleapis.com/prediction_output/mapping/Map%20Kelurahan%20Tondo%20Utara%20Kota%20Palu%20Before.jpg'
        ]);
    }
}
