<?php

namespace App\Http\Controllers;

use App\Models\Report;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Validator;

class ReportController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $limit = request()->limit ?? 15;
        return Report::pimp()->paginate($limit);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'user_id' => 'required',
            'map_id' => 'required',
            'title' => 'required',
            'description' => 'required',
            'photo' => 'required',
            'address' => 'required',
            'category' => 'required',
            'status' => 'required',
        ]);

        if ($validator->fails()) {
            return response()->json($validator->errors());
        }

        $user = Report::create([
            'user_id' => $request->get('user_id'),
            'map_id' => $request->get('map_id'),
            'title' => $request->get('title'),
            'description' => $request->get('description'),
            'photo' => $request->get('photo'),
            'address' => $request->get('address'),
            'category' => $request->get('category'),
            'status' => $request->get('status'),
        ]);

        return response()->json($user);
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $user = Report::where('id', $id)->first();
        return response()->json($user);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $validator = Validator::make($request->all(), [
            'user_id' => 'required',
            'map_id' => 'required',
            'title' => 'required',
            'description' => 'required',
            'photo' => 'required',
            'address' => 'required',
            'category' => 'required',
            'status' => 'required',
        ]);

        if ($validator->fails()) {
            return response()->json($validator->errors());
        }

        $user = Report::where('id', $id)->first();
        if (!$user) {
            return response()->json(['error' => 'Data not found!'], 404);
        }

        $user->user_id = $request->get('user_id');
        $user->map_id = $request->get('map_id');
        $user->title = $request->get('title');
        $user->description = $request->get('description');
        $user->photo = $request->get('photo');
        $user->address = $request->get('address');
        $user->category = $request->get('category');
        $user->status = $request->get('status');

        $user->save();

        return response()->json($user);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $user = Report::where('id', $id)->first();
        if (!$user) {
            return response()->json(['error' => 'Data not found!'], 404);
        }

        $user->delete();

        return response()->json(['message' => 'Successfully deleted!'], 200);
    }
}
