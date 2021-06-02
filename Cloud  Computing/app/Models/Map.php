<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Jedrzej\Pimpable\PimpableTrait;

class Map extends Model 
{
    use HasFactory, PimpableTrait;

    public $searchable = ['area', 'status', 'photo'];
    public $sortable = ['*'];
    protected $withable = ['*'];

    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = [
        'area',
        'photo',
        'status',
    ];
}
